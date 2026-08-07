package com.shlok.cryptrix
import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shlok.cryptrix.crypto.CryptoManager
import com.google.android.material.snackbar.Snackbar
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cryptoManager = CryptoManager()

        val inputMessage = findViewById<EditText>(R.id.inputMessage)
        val inputKey = findViewById<EditText>(R.id.inputKey)
        val outputText = findViewById<TextView>(R.id.outputText)
        val encryptButton = findViewById<Button>(R.id.encryptButton)
        val decryptButton = findViewById<Button>(R.id.decryptButton)
        val copyButton = findViewById<Button>(R.id.copyButton)
        val shareButton = findViewById<Button>(R.id.shareButton)

        encryptButton.setOnClickListener {
            val msg = inputMessage.text.toString()
            if(msg.isBlank()){
                Snackbar.make(findViewById(android.R.id.content),"Please enter a message",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val password = inputKey.text.toString()
            if(password.isBlank()){
                Snackbar.make(findViewById(android.R.id.content),"Please enter a password",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try{
                outputText.text=cryptoManager.encrypt(msg,password)
                Snackbar.make(findViewById(android.R.id.content),"Message encrypted successfully ✅",Snackbar.LENGTH_SHORT).show()
            }catch (e:Exception){
                Snackbar.make(findViewById(android.R.id.content),"Encryption failed",Snackbar.LENGTH_SHORT).show()
            }
        }

        decryptButton.setOnClickListener {
            val msg = inputMessage.text.toString()
            if(msg.isBlank()){
                Toast.makeText(this,"Enter Message",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val password = inputKey.text.toString()
            if(password.isBlank()){
                Toast.makeText(this,"Enter Password",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try{
                outputText.text=cryptoManager.decrypt(msg,password)
                Snackbar.make(findViewById(android.R.id.content),"Message decrypted successfully ✅",Snackbar.LENGTH_SHORT).show()
            }catch (e:Exception){
                Toast.makeText(this,"Wrong Password or Invalid Encrypted Text",Toast.LENGTH_SHORT).show()
            }
        }

        copyButton.setOnClickListener {
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("text", outputText.text)
            clipboard.setPrimaryClip(clip)
            Snackbar.make(findViewById(android.R.id.content),"Copied to clipboard \uD83D\uDCCB",Snackbar.LENGTH_SHORT).show()
        }

        shareButton.setOnClickListener {

            val text = outputText.text.toString()

            if (text.isBlank() || text == "Encrypted text will appear here") {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Nothing to share",
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, text)
            }

            startActivity(Intent.createChooser(intent, "Share Encrypted Text"))
        }
    }


}
