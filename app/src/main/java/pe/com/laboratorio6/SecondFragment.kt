package pe.com.laboratorio6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import pe.com.laboratorio6.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private  lateinit var btnReserva1 :Button
    private  lateinit var btnReserva2 :Button
    private  lateinit var btnReserva3 :Button
    private  lateinit var btnReserva4 :Button




    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnReserva1.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_reserva)
        }
        binding.btnReserva2.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_reserva)
        }
        binding.btnReserva3.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_reserva)
        }
        binding.btnReserva4.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_reserva)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}