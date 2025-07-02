package vazquez.paul.crud_vazquezpaul

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class TareaAdapter(
    var listaTareas: List<Tarea>,
    var onBorrarClic: (String) -> Unit,
    var onActualizarClicl: (Tarea) -> Unit
): RecyclerView.Adapter<TareaAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val cvTarea: CardView = itemView.findViewById(R.id.cvTarea)
        val tvTitulo: TextView = itemView.findViewById(R.id.tvTitulo)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcion)
        val ibtnBorrar: ImageButton = itemView.findViewById(R.id.ibtnButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_tarea, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaTareas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarea = listaTareas[position]

        holder.tvTitulo.text = tarea.titulo
        holder.tvDescripcion.text = tarea.descripcion

        holder.ibtnBorrar.setOnClickListener{
            onBorrarClic(tarea.id)
        }

        holder.cvTarea.setOnClickListener{
            onActualizarClicl(tarea)
        }

    }
}