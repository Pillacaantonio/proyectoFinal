package pe.com.laboratorio6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import pe.com.laboratorio6.utilidad.Util

class ActividadLogin : AppCompatActivity() {
    private lateinit var txtUsu: EditText
    private lateinit var txtCla: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnSalir: Button
    private val objutilidad: Util = Util()
    var usu=""
    var cla=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_login)
        //creamos los controles
        txtUsu=findViewById(R.id.txtUsu)
        txtCla=findViewById(R.id.txtCla)
        btnIngresar=findViewById(R.id.btnIngresar)
        btnSalir=findViewById(R.id.btnSalir)
        //agregamos eventos para los botones
        btnIngresar.setOnClickListener {
            if(txtUsu.getText().toString()==""){
                objutilidad.MensajeAlerta(this,
                    "Ingreso al Sistema",
                    "Ingrese el Usuario",
                    false,
                    "Aceptar")
                txtUsu.requestFocus()
            }else if(txtCla.getText().toString()==""){
                objutilidad.MensajeAlerta(this,
                    "Ingreso al Sistema",
                    "Ingrese la contraseña",
                    false,
                    "Aceptar")
                txtCla.requestFocus()
            }else{
                usu=txtUsu.text.toString()
                cla=txtCla.text.toString()

                if(usu=="antonio" && cla=="pillaca"){
                    objutilidad.MensajeAlerta(this,
                        "Ingreso al Sistema",
                        "Bienvenidos al Sistema",
                        false,
                        "Aceptar")
                    val formulario= Intent(this,MainActivity::class.java)
                    startActivity(formulario)
                    finish()
                }else{
                    objutilidad.MensajeAlerta(this,
                        "Ingreso al Sistema",
                        "Usuario o clave invalida",
                        false,
                        "Aceptar")
                    objutilidad.Limpiar(findViewById<View>(R.id.frmIngreso) as ViewGroup)
                }
            }

        }

        btnSalir.setOnClickListener {
            objutilidad.SalirSistema(this)
        }
    }
}
