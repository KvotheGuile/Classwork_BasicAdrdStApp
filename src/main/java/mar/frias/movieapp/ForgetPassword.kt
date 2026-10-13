package mar.frias.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ForgetPassword : AppCompatActivity() {

    lateinit var btn_goBack: Button
    lateinit var btn_sendEmail: Button
    lateinit var field_email: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forget_password)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn_goBack = findViewById<Button>(R.id.btn_goback)
        btn_sendEmail = findViewById<Button>(R.id.btn_sendemail)
        field_email = findViewById<EditText>(R.id.field_email)


        btn_goBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_sendEmail.setOnClickListener {
            if (!field_email.text.isEmpty()){
                Toast.makeText(this, "Email Sent!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Write your email", Toast.LENGTH_SHORT).show()
            }
        }

    }
}