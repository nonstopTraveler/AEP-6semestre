const listaLivros = document.getElementById("listaLivros");
const formulario = document.querySelector("form");

let livroEditando = null;


// LISTAR LIVROS
async function carregarLivros() {

    const resposta = await fetch("/livros");

    const livros = await resposta.json();

    listaLivros.innerHTML = "";

    if (livros.length === 0) {
        listaLivros.innerHTML = "Nenhum livro cadastrado.";
        return;
    }

    livros.forEach(livro => {

        const div = document.createElement("div");

        div.innerHTML = `
            <p>
                <strong>${livro.titulo}</strong><br>
                Autor: ${livro.autor}<br>
                Categoria: ${livro.categoria}<br>
                Estado: ${livro.estadoConservacao}<br>
                Disponível: ${livro.disponivel ? "Sim" : "Não"}
            </p>

            <button onclick="editarLivro('${livro.id}')">
                Editar
            </button>

            <button onclick="excluirLivro('${livro.id}')">
                Excluir
            </button>

            <hr>
        `;

        listaLivros.appendChild(div);
    });
}


// CADASTRAR OU ATUALIZAR LIVRO
formulario.addEventListener("submit", async function(event) {

    event.preventDefault();

    const livro = {
        titulo: document.getElementById("titulo").value,
        autor: document.getElementById("autor").value,
        categoria: document.getElementById("categoria").value,
        estadoConservacao: document.getElementById("estadoConservacao").value,
        disponivel: document.getElementById("disponivel").checked
    };


    // SE ESTIVER EDITANDO
    if (livroEditando !== null) {

        const resposta = await fetch(`/livros/${livroEditando}`, {
            method: "PUT",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(livro)
        });

        if (resposta.ok) {

            alert("Livro atualizado com sucesso!");

            livroEditando = null;

            formulario.querySelector("button").textContent = "Cadastrar livro";

            formulario.reset();

            document.getElementById("disponivel").checked = true;

            carregarLivros();

        } else {

            alert("Erro ao atualizar o livro.");
        }

        return;
    }


    // SE FOR UM NOVO CADASTRO
    const resposta = await fetch("/livros", {
        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(livro)
    });

    if (resposta.ok) {

        alert("Livro cadastrado com sucesso!");

        formulario.reset();

        document.getElementById("disponivel").checked = true;

        carregarLivros();

    } else {

        alert("Erro ao cadastrar o livro.");
    }
});


// EDITAR LIVRO
async function editarLivro(id) {

    const resposta = await fetch(`/livros/${id}`);

    if (!resposta.ok) {
        alert("Livro não encontrado.");
        return;
    }

    const livro = await resposta.json();

    document.getElementById("titulo").value = livro.titulo;
    document.getElementById("autor").value = livro.autor;
    document.getElementById("categoria").value = livro.categoria;
    document.getElementById("estadoConservacao").value = livro.estadoConservacao;
    document.getElementById("disponivel").checked = livro.disponivel;

    livroEditando = livro.id;

    formulario.querySelector("button").textContent = "Salvar alterações";

    window.scrollTo({
        top: 0,
        behavior: "smooth"
    });
}

async function excluirLivro(id) {

    const confirmar = confirm("Tem certeza que deseja excluir este livro?");

    if (!confirmar) {
        return;
    }

    const resposta = await fetch(`/livros/${id}`, {
        method: "DELETE"
    });

    if (resposta.ok) {

        alert("Livro excluído com sucesso!");

        carregarLivros();

    } else {

        alert("Erro ao excluir o livro.");
    }
}

carregarLivros();