//Exemplo de evento 
/* let botao = document.querySelector('a#add');
botao.addEventListener('click', funcaoA);
botao.addEventListener('click', funcaoB);

function funcaoA() {
    alert('A');
}
function funcaoB() {
    alert('B');
} */

// Altera o tema quando mudar a opção selecionada
let selectTema = document.querySelector('select#tema');
selectTema.addEventListener('change', evento => {
    let temaSelecionado = evento.target.value;
    //console.log(temaSelecionado);
    if (temaSelecionado) {
        mudaTema(temaSelecionado);
        // Salva a opção de tema escolhida pelo usuário no localStorage
        localStorage.setItem('tema', temaSelecionado);
    }
});

// Altera o tema o arquivo CSS de acordo com o tema selecionado
const mudaTema = (temaSelecionado) => {
    let linkTema = document.querySelector('#link-tema');
    //console.log(linkTema);
    let url = "/Joao_Carlos/css/estilo-tema-" + temaSelecionado + ".css";
    linkTema.href = url;
}

// Recupera a opção de tema escolhida pelo usuário e
// altera o tema se houver uma opção salva no localStorage
let tema = localStorage.getItem('tema');
if (tema) {
    mudaTema(tema);
}

//Função que carrega dados dos profissionais a partir de um objeto JSON
const carregarProfissionais = () => {
    let url = "https://my-json-server.typicode.com/juniorlimeiras/json/profissionais";
    let tabela = document.querySelector('table');
    fetch(url).then(resposta => {
        return resposta.json();
    }).then(dados => {
        for (const item of dados) {
            inserirProfissional(item);
        }
        eventoExcluir();
    }).catch(erro => {
        console.error(erro);
    });
    /* let xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    xhr.addEventListener('readystatechange', () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            dados = JSON.parse(xhr.responseText);
            //console.log(dados);
            for (const item of dados) {
                //Criando os elementos HTML
                let linha = document.createElement('tr');
                let id = document.createElement('td');
                let nome = document.createElement('td');
                let registroConselho = document.createElement('td');
                let telefone = document.createElement('td');
                let email = document.createElement('td');
                let unidade = document.createElement('td');
                let especialidade = document.createElement('td');
                let acoes = document.createElement('td');
                //Preencher os elementos
                id.textContent = item.id;
                nome.textContent = item.nome;
                registroConselho.textContent = item.registro;
                telefone.textContent = item.telefone;
                email.textContent = item.email;
                unidade.textContent = item.unidade;
                especialidade.textContent = item.especialidade;
                acoes.innerHTML = `<a class="botao">Editar</a> <a id="vermelho" class="botao">Excluir</a>`;
                //Preencher a linha
                linha.appendChild(id);
                linha.append(nome);
                linha.appendChild(registroConselho);
                linha.appendChild(email);
                linha.appendChild(telefone);
                linha.appendChild(unidade);
                linha.appendChild(especialidade);
                linha.appendChild(acoes);
                //Preencher a tabela com uma linha
                tabela.tBodies[0].appendChild(linha);
            }
        }
        eventoExcluir();
    });
    xhr.send(); */
};
carregarProfissionais();

//Função para excluir um profissional
const eventoExcluir = () => {
    let botoes = document.querySelectorAll('a.botao#vermelho');
    for (const bt of botoes) {
        bt.addEventListener('click', () => {
            bt.parentNode.parentNode.remove();
            atualizarTotalRegistros();
        });
    };
};

let botaoAdicionar = document.querySelector('a.botao#add');
let form = document.querySelector('form');
let botaoCancelar = document.querySelector('input#vermelho');

//Adiciona o evento de click ao botao Adicionar
botaoAdicionar.addEventListener('click', () => {
    form.classList.remove('inativo');
    botaoAdicionar.style.display ="none";
});

//Adiciona o evento de click ao botao Cancelar
botaoCancelar.addEventListener('click', () => {
    form.classList.add('inativo');
    form.reset();
    botaoAdicionar.style.display ="";
    atualizarTotalRegistros();
})

let tabela = document.querySelector('table');
//Adicionar um funcionamento para enviar os dados do form para a tabela
form.addEventListener('submit', (evento) => {
    evento.preventDefault(); //Evita que a página seja recarregada
    let profissional = { //Cria um objeto com os dados do form
        id: tabela.tBodies[0].rows.length + 1,
        nome: form.nome.value,
        registro: form.registro.value,
        telefone: form.telefone.value,
        email: form.email.value,
        unidade: form.unidade.options[form.unidade.selectedIndex].label,
        especialidade: form.especialidade.options[form.especialidade.selectedIndex].label
    };
    //console.log(profissional);
    inserirProfissional(profissional); //insere o profissional na tabela
    form.reset(); //Limpa os campos do form
    form.classList.add('inativo'); //Esconde o form
    botaoAdicionar.style.display ="";
    eventoExcluir(); //Adiciona o evento de excluir ao botao criado ao inserir nova linha na tabela
});

//Função que insere um objeto profissional na tabela HTML
const inserirProfissional = (item) => {
    //Criando os elementos HTML
    let linha = document.createElement('tr');
    let id = document.createElement('td');
    let nome = document.createElement('td');
    let registro = document.createElement('td');
    let telefone = document.createElement('td');
    let email = document.createElement('td');
    let unidade = document.createElement('td');
    let especialidade = document.createElement('td');
    let acoes = document.createElement('td');
    //Preencher os elementos
    id.textContent = item.id;
    nome.textContent = item.nome;
    registro.textContent = item.registro;
    telefone.textContent = item.telefone;
    email.textContent = item.email;
    unidade.textContent = item.unidade;
    especialidade.textContent = item.especialidade;
    acoes.innerHTML = `<a class="botao">Editar</a> <a id="vermelho" class="botao">Excluir</a>`;
    //Preencher a linha
    linha.appendChild(id);
    linha.append(nome);
    linha.appendChild(registro);
    linha.appendChild(email);
    linha.appendChild(telefone);
    linha.appendChild(unidade);
    linha.appendChild(especialidade);
    linha.appendChild(acoes);
    //Preencher a tabela com uma linha
    tabela.tBodies[0].appendChild(linha);
    atualizarTotalRegistros();
};
const atualizarTotalRegistros = () => {
    totalRegistros.textContent = tabela.tBodies[0].rows.length;
};
