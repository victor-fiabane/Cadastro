package br.ulbra;

import android.view.View;
import android.widget.Button;

public class TelaPrincipal {
    MainActivity act;
    Button btnCadastra;
    Button btnLista;
    TelaCadastroUsuario tela_cadastro;
    TelaListagemUsuarios tela_listagem;
    public TelaPrincipal(MainActivity act) {
        this.act = act;
    }
    public void CarregarTela()  {
        act.setContentView(R.layout.tela_principal);
        btnCadastra = (Button)
                act.findViewById(R.id.btnCadastra);
                btnLista = (Button)
                act.findViewById(R.id.btnLista);
        btnCadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tela_cadastro.CarregarTela();
            }});
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    tela_listagem.CarregarTela();
            }
        });}
        public void setTelaCadastro(TelaCadastroUsuario tela_cadastro){
            this.tela_cadastro = tela_cadastro;
        }
        public void setTelaListagem(TelaListagemUsuarios tela_listagem){
            this.tela_listagem = tela_listagem;
        }
    }


