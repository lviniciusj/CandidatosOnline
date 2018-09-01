package com.lviniciusj.br.candidatosonline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.lviniciusj.br.candidatosonline.api.Candidato;

import java.util.List;

public class ListaAdapter extends BaseAdapter {

    private Context context;
    private List<Candidato> lista;
    private ViewHolder holder;

    public ListaAdapter(Context context, List<Candidato> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Candidato getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Candidato candidato = lista.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.linha, null);
            holder = new ViewHolder();
            holder.foto = (ImageView) convertView.findViewById(R.id.fotoCandidato);
            holder.nome = (TextView) convertView.findViewById(R.id.nomeCandidato);
            holder.partido = (TextView) convertView.findViewById(R.id.partidoCandidato);
            holder.totalVotos  = (TextView) convertView.findViewById(R.id.totalVotoCandidato);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nome.setText(candidato.getNome());
        holder.partido.setText(candidato.getPartido());
        holder.totalVotos.setText(String.valueOf(candidato.getTotalVotos()));


        Ion.with(holder.foto)
                .centerCrop()
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.error)
                .animateIn(R.anim.fade_in)
                .load(Constants.PATH_URL + "/" + candidato.getFoto());

        return convertView;
    }

    static class ViewHolder {
        ImageView foto;
        TextView nome;
        TextView partido;
        TextView totalVotos;
    }
}
