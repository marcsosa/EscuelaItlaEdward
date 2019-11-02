package com.itla.testappdb.repositorio;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itla.testappdb.entidades.Carrera;
import com.itla.testappdb.R;

import java.util.List;
public class AdaptadorCarrera extends RecyclerView.Adapter<AdaptadorCarrera.MyViewHolder>
{
    private List<Carrera> listaCarrera;

    public AdaptadorCarrera(List<Carrera> listaCarrera) {
        this.listaCarrera = listaCarrera;
    }

    public List<Carrera> getListCarrera(){
        return  listaCarrera;
    }

    public void setListaDeCarrera(List<Carrera> listaCarrera) {
        this.listaCarrera = listaCarrera;

    }

    ;    @Override
public AdaptadorCarrera.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_plantillacarrera,null,false);
    return new MyViewHolder(view);
}
    @Override
    public void onBindViewHolder(@NonNull AdaptadorCarrera.MyViewHolder myViewHolder, int position) {
        Carrera car = listaCarrera.get(position);
        myViewHolder.carreraNom.setText(car.getNombre());
        myViewHolder.materiasNum.setText(car.getMateria().toString());
        myViewHolder.creditosNum.setText(car.getCreditos().toString());



    }

    @Override
    public int getItemCount() {
        return listaCarrera.size();
    }



    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView carreraNom, materiasNum, creditosNum;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            carreraNom = (TextView) itemView.findViewById(R.id.txtCarrera);
            materiasNum = (TextView) itemView.findViewById(R.id.txtmaterias);
            creditosNum = (TextView) itemView.findViewById(R.id.txtcreditos2);
        }

    }

}

