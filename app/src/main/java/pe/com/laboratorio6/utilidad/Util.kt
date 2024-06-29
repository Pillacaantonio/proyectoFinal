package pe.com.laboratorio6.utilidad

import android.app.Activity
import android.content.Context
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog

class    Util {
    //creamos una variable para la alerta
    private var dialogo: AlertDialog.Builder?=null
    //creamos una funcion para que limpie todos los controles
    fun Limpiar(viewGroup: ViewGroup){
        var i=0
        val count=viewGroup.childCount
        while(i<count){
            val view=viewGroup.getChildAt(i)
            //limpiando cajas de texto
            if(view is EditText){
                view.setText("")
            }
            //limpiando radio button
            if(view is RadioGroup){
                (view.getChildAt(0) as RadioButton).isChecked=false
            }
            //limpiando el spinner
            if(view is Spinner){
                view.setSelection(0)
            }
            //limpiando checkbox
            if(view is CheckBox){
                view.isChecked=false
            }
            if(view is ViewGroup && view.childCount>0){
                Limpiar(view as ViewGroup)
            }
            i++
        }
    }
    //funcion que pemrita salir del sistema
    fun SalirSistema(context: Context){
        dialogo=AlertDialog.Builder(context)
        dialogo!!.setTitle("Saliendo del Sistema")
        dialogo!!.setMessage("¿Estas seguro que quieres salir del sistema?")
        dialogo!!.setCancelable(false)
        dialogo!!.setPositiveButton("Si"){
                dialogo,which->(context as Activity).finish()
        }
        dialogo!!.setNegativeButton("No"){
                dialogo,which->
        }
        dialogo!!.show()
    }
    //funcion para mostrar el mensaje
    fun MensajeAlerta(context: Context, titulo:String,
                      mensaje:String, cancelable:Boolean,
                      textobotonpositivo:String){
        dialogo=AlertDialog.Builder(context)
        dialogo!!.setTitle(titulo)
        dialogo!!.setMessage(mensaje)
        dialogo!!.setCancelable(cancelable)
        dialogo!!.setPositiveButton(textobotonpositivo){
                dialogo,which->
        }
        dialogo!!.show()
    }
}