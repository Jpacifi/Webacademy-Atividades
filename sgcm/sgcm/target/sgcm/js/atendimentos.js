// Insere dados de um atendimento na tabela
const inserirAtendimento = (item) => {

    // Cria os elementos HTML
    let linha = document.createElement('tr');
    let id = document.createElement('td');
    let data = document.createElement('td');
    let status = document.createElement('td');
    let convenioId = document.createElement('td');
    let pacienteId = document.createElement('td');
    let profissionalId = document.createElement('td');
    let acoes = document.createElement('td');

    // Adiciona os dados do atendimento nos elementos criados
    id.classList.add('fit');
    id.textContent = item.id;
    data.textContent = item.data;
    status.textContent = item.status;
    convenioId.textContent = item.convenio_id;
    pacienteId.textContent = item.paciente_id;
    profissionalId.textContent = item.profissional_id;
    acoes.innerHTML = `
        <a href="atendimentosForm.jsp?id=${item.id}"
            class="botao">Editar</a>
        <a href="atendimentos.jsp?excluir=${item.id}"
            class="botao excluir">Excluir</a>
        `;

    // Adiciona os elementos criados na linha da tabela
    linha.appendChild(id);
    linha.appendChild(data);
    linha.appendChild(status);
    linha.appendChild(convenioId);
    linha.appendChild(pacienteId);
    linha.appendChild(profissionalId);
    linha.appendChild(acoes);

    // Adiciona a linha na tabela
    let tabela = document.querySelector('table');
    tabela.tBodies[0].appendChild(linha);

}

// Função para limpar a tabela
const limparTabela = () => {
    let tabela = document.querySelector('table');
    let linhas = tabela.tBodies[0].querySelectorAll('tr');
    linhas.forEach(linha => linha.remove());
}

// Função para adicionar eventos de exclusão
const adicionarEventoExcluir = () => {
    let botoesExcluir = document.querySelectorAll('.botao.excluir');
    botoesExcluir.forEach(botao => {
        botao.addEventListener('click', (evento) => {
            evento.preventDefault();
            let url = botao.href;
            fetch(url)
                .then(() => {
                    botao.closest('tr').remove();
                    atualizarTotal();
                });
        });
    });
}

// Função para atualizar o total de registros
const atualizarTotal = () => {
    let total = document.querySelector('table').tBodies[0].querySelectorAll('tr').length;
    document.querySelector('#total').textContent = total;
}

let campoBusca = document.querySelector('input[name="busca"]');
campoBusca.addEventListener('input', (evento) => {
    let termoBusca = evento.target.value;
    if (termoBusca.length >= 3 || termoBusca.length == 0) {
        let url = './atendimento?busca=' + termoBusca;
        fetch(url)
            .then(resposta => resposta.json())
            .then(dados => {
                limparTabela();
                for (const item of dados) {
                    inserirAtendimento(item);
                }
                adicionarEventoExcluir();
                atualizarTotal();
            });
    }
});
