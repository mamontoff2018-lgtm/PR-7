package com.example.localizationandformslab

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    private val TAG = "Registration"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val etFio = findViewById<EditText>(R.id.etFio)
        val etLogin = findViewById<EditText>(R.id.etLogin)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            val fio = etFio.text.toString().trim()
            val login = etLogin.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            var isValid = true

            if (!Regex("^[А-Яа-яЁё\\s-]+$").matches(fio)) {
                etFio.error = "Только русские буквы, пробелы и дефис"
                Log.w(TAG, "Неверный формат ФИО: $fio")
                isValid = false
            }

            if (!Regex("^[A-Za-z]+$").matches(login)) {
                etLogin.error = "Только латинские буквы"
                Log.w(TAG, "Неверный формат логина: $login")
                isValid = false
            }

            if (!Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$").matches(email)) {
                etEmail.error = "Неверный формат email"
                Log.w(TAG, "Неверный формат email: $email")
                isValid = false
            }

            if (!Regex("^\\+7\\d{10}$").matches(phone)) {
                etPhone.error = "Формат: +7XXXXXXXXXX"
                Log.w(TAG, "Неверный формат телефона: $phone")
                isValid = false
            }

            if (password.length < 6) {
                etPassword.error = "Пароль должен быть не менее 6 символов"
                Log.w(TAG, "Слишком короткий пароль")
                isValid = false
            }

            if (password != confirmPassword) {
                etConfirmPassword.error = "Пароли не совпадают"
                Log.w(TAG, "Пароли не совпадают")
                isValid = false
            }

            if (isValid) {
                Toast.makeText(this, "Регистрация успешна!", Toast.LENGTH_LONG).show()
                Log.i(TAG, "Регистрация прошла успешно")
                finish()
            } else {
                Toast.makeText(this, "Исправьте ошибки в форме", Toast.LENGTH_LONG).show()
            }
        }
    }
}