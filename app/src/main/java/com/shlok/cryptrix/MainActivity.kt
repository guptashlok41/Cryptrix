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

        encryptButton.setOnClickListener {
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
                outputText.text=cryptoManager.encrypt(msg,password)
            }catch (e:Exception){
                Toast.makeText(this,"Encryption Failed",Toast.LENGTH_SHORT).show()
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
            }catch (e:Exception){
                Toast.makeText(this,"Wrong Password or Invalid Encrypted Text",Toast.LENGTH_SHORT).show()
            }
        }

        copyButton.setOnClickListener {
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("text", outputText.text)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Copied to clipboard!", Toast.LENGTH_SHORT).show()
        }
    }


}
