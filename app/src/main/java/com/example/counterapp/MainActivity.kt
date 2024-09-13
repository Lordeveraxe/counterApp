package com.example.counterapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Nombre del archivo de preferencias
    private val prefsName = "CounterPrefs"
    private val counterKey = "counter"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener el TextView donde mostraremos el contador
        val counterTextView: TextView = findViewById(R.id.counterTextView)
        val resetButton: Button = findViewById(R.id.resetButton)

        // Recuperar el valor guardado de SharedPreferences
        val sharedPreferences = getSharedPreferences(prefsName, Context.MODE_PRIVATE)
        var counter = sharedPreferences.getInt(counterKey, 0)

        // Incrementar el contador
        counter++

        // Guardar el nuevo valor en SharedPreferences
        val editor = sharedPreferences.edit()
        editor.putInt(counterKey, counter)
        editor.apply()

        // Mostrar el contador en la pantalla
        counterTextView.text = counter.toString()

        // Configurar el botón de reinicio para resetear el contador a 0
        resetButton.setOnClickListener {
            counter = 0
            counterTextView.text = counter.toString()

            // Guardar el valor reiniciado en SharedPreferences
            editor.putInt(counterKey, counter)
            editor.apply()
        }
    }
}