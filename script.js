let selectTema = document.querySelector('select#tema');
selectTema.addEventListener('change', evento => { 
    let temaSelecionado = evento.target.value;
    //console.log(temaSelecionado);
    if(temaSelecionado) { 
        mudaTema(temaSelecionado);
        localStorage.setItem('tema', temaSelecionado)
    }
});
 
const mudaTema = (temaSelecionado) => { 
    let linkTema = document.querySelector('#link-tema');
    let url = "/css/estilo-tema-"+temaSelecionado+".css"
    linkTema.href = url; 
}

let tema = localStorage.getItem('tema');
if(tema) { 
    mudaTema(tema); 
}

const carregarUnidades = () => {
    let url = "https://my-json-server.typicode.com/juniorlimeiras/json/unidades";
    let tabela = document.querySelector('table');
    fetch(url).then(resposta => {
        return resposta.json();
    }).then(dados => {
        for (const item of dados) {
            inserirUnidade(item);
        }
        eventoExcluir();
    }).catch(erro => {
        console.error(erro);
    });

};
carregarUnidades(); 

//Função para excluir um unidade
const eventoExcluir = () => {
    let botoes = document.querySelectorAll('a.botao#vermelho');
    for (const bt of botoes) {
        bt.addEventListener('click', () => {
            bt.parentNode.parentNode.remove();
        });
    };
};

let botaoAdicionar = document.querySelector('a.botao#add');
let form = document.querySelector('form');
let botaoCancelar = document.querySelector('input#vermelho');

//Adiciona o evento de click ao botao Adicionar
botaoAdicionar.addEventListener('click', () => {
    form.classList.remove('inativo');
});

//Adiciona o evento de click ao botao Cancelar
botaoCancelar.addEventListener('click', () => {
    form.classList.add('inativo');
    form.reset();
})

let tabela = document.querySelector('table');
//Adicionar um funcionamento para enviar os dados do form para a tabela
form.addEventListener('submit', (evento) => {
    evento.preventDefault(); //Evita que a página seja recarregada
    let unidade = { //Cria um objeto com os dados do form
        id: tabela.tBodies[0].rows.length + 1,
        endereco: form.endereco.value,
        nome: form.nome.value,
    };
    inserirUnidade(unidade); //insere o unidade na tabela
    form.reset(); //Limpa os campos do form
    form.classList.add('inativo'); //Esconde o form
    eventoExcluir(); //Adiciona o evento de excluir ao botao criado ao inserir nova linha na tabela
});

//Função que insere um objeto unidade na tabela HTML
const inserirUnidade = (item) => {
    //Criando os elementos HTML
    let linha = document.createElement('tr');
    let id = document.createElement('td');
    let endereco = document.createElement('td');
    let nome = document.createElement('td');
    let acoes = document.createElement('td');
    //Preencher os elementos
    id.textContent = item.id;
    endereco.textContent = item.endereco;
    nome.textContent = item.nome;
    acoes.innerHTML = `<a class="botao">Editar</a> <a id="vermelho" class="botao">Excluir</a>`;
    //Preencher a linha
    linha.appendChild(id);
    linha.appendChild(endereco);
    linha.append(nome);
    linha.appendChild(acoes);
    //Preencher a tabela com uma linha
    tabela.tBodies[0].appendChild(linha);
};