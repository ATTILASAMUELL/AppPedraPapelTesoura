package attila.samuell.pedrapapeltesouraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgPrincipal,imgPapel,imgPedra,imgTesoura;
    private TextView txtResultado;


    //Boa noite pessoal, vamos iniciar a parte dois do projeto , mini jogo "pedra, papel, tesoura"....
    // primeiro, vamos implementar uma interface("regra de negocio") para capturar o click do usuario.
    // Segundo passo, vamos capturar os objetos da activity_main... usando os Id, pronto!!!
    // terceito passo:Agora vamos criar um metodo no OnCreate, para carregar os objetos e passar os ids. pronto!!!
    // quarto passo: AGORA vamos criar um metodo que vamos inserir nossa regra de negocio, para que quando o
    // usuario clicar na imagem que ele selecionar, diz se ele ganhou ou não, e nesse mesmo metodo vamos
    // usar o metodo random(gerar)aleatorio.

    // Quinto passo: Vamos usar o Switch + view onclick... para capturar o click do usuario na imagem., antes vamos passar os contexto. pronto!!!

    //Sexto passo: Vamos "tratar" o dados que o cliente clicou.... no metodo OpcaoSelecionadaPeloUsuario(String valorEscolhidoPeloUsuario)....


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarregarObjetosId();

        // Passar o contexto para o setOnclick....
        imgPapel.setOnClickListener(this); //this = esse é o contexto.
        imgPedra.setOnClickListener(this);
        imgTesoura.setOnClickListener(this);


    }

    private void CarregarObjetosId() {
        imgPrincipal = findViewById(R.id.imgPrincipal);
        imgPapel = findViewById(R.id.imgPapel);
        imgPedra = findViewById(R.id.imgPedra);
        imgTesoura = findViewById(R.id.imgTesoura);
        txtResultado = findViewById(R.id.txtResultado);

    }

    private void OpcaoSelecionadaPeloUsuario(String valorEscolhidoPeloUsuario){

        //Regra de negocio, vamos usar o Random.

        int numeroGerado = new Random().nextInt(3);
        //Criar agora uma lista... do tipo string.
        String[] opcoes = {"pedra", "papel","tesoura"};
        String opcoesQueOAppEscolheu = opcoes[numeroGerado];

        //Fazer o tratamento da geração aleatoria que o app gerou.
        switch (opcoesQueOAppEscolheu){
            case "pedra":
                imgPrincipal.setImageResource(R.drawable.pedra_im);
                break;
            case "tesoura":
                imgPrincipal.setImageResource(R.drawable.tesoura_img);
                break;
            case "papel":
                imgPrincipal.setImageResource(R.drawable.papel_im);
                break;

        }

        //Agora vamos  fazer o tratamento do que o usuario escolheu e o que o app gerou (usando random).... Usando IF e if else e else...

        if((opcoesQueOAppEscolheu == "tesoura" && valorEscolhidoPeloUsuario == "papel") ||
                (opcoesQueOAppEscolheu == "papael" && valorEscolhidoPeloUsuario == "pedra") ||
                (opcoesQueOAppEscolheu == "pedra" && valorEscolhidoPeloUsuario == "tesoura") ){
            txtResultado.setText("Você PERDEU!!!");
        } else if ((valorEscolhidoPeloUsuario == "tesoura" && opcoesQueOAppEscolheu == "papel") ||
                (valorEscolhidoPeloUsuario == "papael" && opcoesQueOAppEscolheu == "pedra") ||
                (valorEscolhidoPeloUsuario == "pedra" && opcoesQueOAppEscolheu == "tesoura") ) {
            txtResultado.setText("Você GANHOU!!!");
        }else { //empate
            txtResultado.setText("EMPATOU!!!");
        }

        //Vamos testar se deu certo rsrsrsrsr

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgPapel:
                OpcaoSelecionadaPeloUsuario("papel");
                break;
            case R.id.imgPedra:
                OpcaoSelecionadaPeloUsuario("pedra");
                break;
            case R.id.imgTesoura:
                OpcaoSelecionadaPeloUsuario("tesoura");
                break;
        }

    }
}