package pe.com.laboratorio6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ActividadSplash : AppCompatActivity() {
    private lateinit var btnContinuar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_splash)
        btnContinuar=findViewById(R.id.btnContinuar)
        btnContinuar.setOnClickListener(View.OnClickListener {
            //creamos una constante para llamar a la actividad que vamos abrir
            val formulario= Intent(this,ActividadLogin::class.java)
            //iniciamos la actividad nueva
            startActivity(formulario)
            //cerramos la actividad correspondiente
            finish()
        })
    }
}
