package mar.frias.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class RegisterActivity : AppCompatActivity() {

    lateinit var btn_login: Button
    lateinit var btn_signin: Button

    lateinit var field_name: EditText
    lateinit var field_email: EditText
    lateinit var field_password: EditText
    lateinit var field_password_confirm: EditText
    lateinit var datePicker: DatePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn_login = findViewById<Button>(R.id.btn_in)
        btn_signin = findViewById<Button>(R.id.btn_sign)
        field_name = findViewById<EditText>(R.id.field_name)
        field_email = findViewById<EditText>(R.id.field_email)
        field_password = findViewById<EditText>(R.id.field_password)
        field_password_confirm = findViewById<EditText>(R.id.field_confirm_password)
        datePicker = findViewById<DatePicker>(R.id.datePicker)


        btn_login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        btn_signin.setOnClickListener {
            clickSignIn()
        }
    }

    fun clickSignIn(){
        var empty_field: Boolean = field_email.text.isEmpty() ||
                field_password.text.isEmpty() ||
                field_password_confirm.text.isEmpty() ||
                field_name.text.isEmpty();
        if (empty_field) {
            errorToast("Missing field(s)")
            return;
        }

        if (field_password.text.toString() != field_password_confirm.text.toString()){
            errorToast("Password does not match")
            return;
        }


        val today = Calendar.getInstance()
        var isAdult: Boolean = false
        val age = today.get(Calendar.YEAR) - datePicker.year
        if (age > 18){
            isAdult = true
        }else if (age == 18){
            val monthDiff = today.get(Calendar.MONTH) - datePicker.month
            if (monthDiff > 0){
                isAdult = true
            }
            else if (monthDiff == 0){
                val dayDiff = today.get(Calendar.DAY_OF_MONTH) - datePicker.dayOfMonth

                if (dayDiff >= 0){
                    isAdult = true
                }
            }
        }

        if (!isAdult){
            errorToast("You must be over 18 years old.")
            return;
        }

        Toast.makeText(this, "SUCCESSFUL SIGN UP", Toast.LENGTH_SHORT).show()
    }

    fun errorToast(txt: String){
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show()
    }
}