package com.itla.testappdb.repositorio;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.itla.testappdb.entidades.Estudiante;
import com.itla.testappdb.entidades.Carrera;
import com.itla.testappdb.R;

import org.w3c.dom.Text;

import java.util.List;

public class AdaptadorEstudiante extends RecyclerView.Adapter<AdaptadorEstudiante.MyViewHolder>
{
    private List<Estudiante> listaEstudiante;

    public AdaptadorEstudiante(List<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }

    public List<Estudiante> getListEstudiante(){
        return  listaEstudiante;
    }

    public void setListaDeEstudiante(List<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;

    }

    ;    @Override
public AdaptadorEstudiante.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_plantilla,null,false);
    return new MyViewHolder(view);
}
    @Override
    public void onBindViewHolder(@NonNull AdaptadorEstudiante.MyViewHolder myViewHolder, int position) {
        Estudiante est = listaEstudiante.get(position);
      myViewHolder.carreraEst.setText(est.getCarrera().getId().toString());
        myViewHolder.nomcarreraEst.setText(est.getCarrera().getNombre());
        myViewHolder.nombreEst.setText(est.getNombre());
        myViewHolder.matriculaEst.setText(est.getMatricula());

    }

    @Override
    public int getItemCount() {
        return listaEstudiante.size();
    }



    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView carreraEst,nombreEst,matriculaEst,nomcarreraEst;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            carreraEst = (TextView) itemView.findViewById(R.id.txtCarrera);
            nombreEst = (TextView) itemView.findViewById(R.id.txtNombre);
            nomcarreraEst = (TextView) itemView.findViewById(R.id.txtCarreranombre);
            matriculaEst = (TextView) itemView.findViewById(R.id.txtMatricula);
        }

    }

}

