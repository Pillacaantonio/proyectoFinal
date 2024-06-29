package pe.com.laboratorio6

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.Calendar

class Reserva : Fragment() {

    private lateinit var editTextFechaInicio: EditText
    private lateinit var editTextFechaFin: EditText
    private lateinit var txtCantidad: Number

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reserva, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextFechaInicio = view.findViewById(R.id.editTextFechaInicio)
        editTextFechaFin = view.findViewById(R.id.editTextFechaFin)

        // Configurar selección de fecha para fecha de inicio
        editTextFechaInicio.setOnClickListener {
            seleccionarFecha(editTextFechaInicio)
        }

        // Configurar selección de fecha para fecha de fin
        editTextFechaFin.setOnClickListener {
            seleccionarFecha(editTextFechaFin)
        }

        val buttonReservar = view.findViewById<Button>(R.id.btnReservar)
        val buttonRegresar = view.findViewById<Button>(R.id.btnRegresar)

        buttonReservar.setOnClickListener {
            val fechaInicio = editTextFechaInicio.text.toString()
            val fechaFin = editTextFechaFin.text.toString()

            // Aquí puedes implementar la lógica para procesar las fechas
            // Por ejemplo, mostrar un mensaje con las fechas ingresadas
            val mensaje = "Reservado desde $fechaInicio hasta $fechaFin"
            Toast.makeText(requireContext(), mensaje, Toast.LENGTH_SHORT).show()
        }

        buttonRegresar.setOnClickListener {
            // Aquí puedes implementar la acción al presionar el botón "Regresar"
            Toast.makeText(requireContext(), "Regresar presionado", Toast.LENGTH_SHORT).show()
            // Por ejemplo, podrías cerrar la actividad actual
            activity?.finish()
        }
    }

    // Método para seleccionar fecha usando DatePickerDialog
    private fun seleccionarFecha(editText: EditText) {
        val calendario = Calendar.getInstance()
        val año = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(
            requireContext(),
            { _, year, monthOfYear, dayOfMonth ->
                val fechaSeleccionada = "${dayOfMonth}/${monthOfYear + 1}/${year}"
                editText.setText(fechaSeleccionada)
            },
            año,
            mes,
            dia
        )
        datePicker.show()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Reserva().apply {
                arguments = Bundle().apply {

                }
            }
    }
}