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

class MainActivity : AppCompatActivity() {

    lateinit var btn_login: Button
    lateinit var btn_signin: Button
    lateinit var field_email: EditText
    lateinit var field_password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn_login = findViewById<Button>(R.id.btn_in)
        btn_signin = findViewById<Button>(R.id.btn_sign)
        field_email = findViewById<EditText>(R.id.field_email)
        field_password = findViewById<EditText>(R.id.field_password)

        btn_signin.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener {
            var user = field_email.text.toString()
            var password = field_password.text.toString()

            if (user == "root" && password == "rootpass"){
                Toast.makeText(this, "Login Completed", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Incorrect User", Toast.LENGTH_SHORT).show()
            }

        }

    }
}