package com.wandeco.alcoolougasolinakotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

    }

    fun calcularPreco(view: View) {
        //val precoAlcool = findViewById<EditText>(R.id.precoAlcool)
        //val precoGasolina = findViewById<EditText>(R.id.editPrecoGasolina)

        val precoAlcool = editPrecoAlcool.text.toString()
        val precoGasolina = editPrecoGasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool,precoGasolina)
        if(validaCampos){
            calcularMelhorPreco(precoAlcool,precoGasolina)
        }else{
            textResultado.text = "Preencha os valores antes!!"
        }

    }

    fun validarCampos(precoAlcool: String, precoGasolina: String) : Boolean {

        var camposValidados = true
        if (precoAlcool == null || precoAlcool == "") {
            camposValidados = false
        } else if (precoGasolina == null || precoGasolina == "") {
            camposValidados = false
        }

        return camposValidados
    }

    fun calcularMelhorPreco(precoAlcool: String,precoGasolina: String){

        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()
        val resultado = valorAlcool/valorGasolina

        if(resultado >= 0.7){
            textResultado.text = "Melhor Usar Gasolina"
        }else{
            textResultado.text = "Melhor Usar Alcool"
        }

    }

}