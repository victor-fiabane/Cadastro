package br.ulbra;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaListagemUsuarios {
    MainActivity act;
    TelaPrincipal tela_principal;
    Button btnVolta, btnVai, btnSair, btnLimpa;
    TextView nome2, telefone2, endereco2, status;
    int index;
    public TelaListagemUsuarios(
            MainActivity act, TelaPrincipal   tela_principal) {
        this.act = act;
        this.tela_principal = tela_principal;
        index = 0;
    }
    public void CarregarTela()  {
//Antes de carregar a tela, verifica se existe registros
        //inseridos
        if(act.getRegistros().size() == 0)   {
            (new AlertDialog.Builder(act))    .setTitle("Aviso")
                    .setMessage("Não existe nenhum registro cadastrado.")
                    .setNeutralButton("OK", null).show();
            return;
        }
        act.setContentView(R.layout.tela_listagem);
        btnVolta = (Button) act.findViewById(R.id.btnVolta);
        btnVai = (Button) act.findViewById(R.id.btnVai);
        btnSair = (Button) act.findViewById(R.id.btnSair);
        nome2 = (TextView) act.findViewById(R.id.nome2);
        endereco2 = (TextView) act.findViewById(R.id.endereco2);
        telefone2 = (TextView) act.findViewById(R.id.telefone2);
        status = (TextView) act.findViewById(R.id.status);
        PreencheCampos(index);
        AtualizaStatus(index);
        btnVolta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index > 0) {
                    index--;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }        }   });
        btnVai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(index < act.getRegistros().size() - 1){
                    index++;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }   });
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela_principal.CarregarTela();
            }   });
    }
    private void PreencheCampos(int idx)  {
        nome2.setText(act.getRegistros().get(idx).getNome());
        telefone2.setText(act.getRegistros().get(idx).getTelefone());
        endereco2.setText(act.getRegistros().get(idx).getEndereco());
    }
    private void AtualizaStatus(int idx) {
        int total = act.getRegistros().size();
        status.setText("Registros : " + (idx+1) + "/" + total);
    }
}
