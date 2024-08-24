const inputs = document.querySelectorAll(".input");
const tbody = document.querySelector("tbody");
const form = document.querySelector("main");

function add() {
    if (isSet()) {
        const tr = document.createElement("tr");
        tbody.appendChild(tr);
        inputs.forEach(i => {
            let td = document.createElement("td");
            td.innerHTML = i.value;
            i.value = null;
            i.classList.remove('has-value');
            tr.appendChild(td);
        });
        let td = document.createElement("td");
        td.innerHTML = '<button class="delete" title="Remover"><span class="material-symbols-outlined">remove</span></button>'+
                        '<button class="edit" title="Editar"><span class="material-symbols-outlined">edit</span></button>';
        td.firstElementChild.addEventListener("click", () => delTd(td));
        td.lastElementChild.addEventListener("click", () => editTr(td));
        tr.appendChild(td);
        closeForm();
    } else alert("Preencha todos os campos!");
}

function editTr(e){
    const tr = e.parentNode;
    const tds = tr.children;
    let backup = [];
    for(let i = 0; i <= 5; i++){
        const input = document.createElement("input");
        input.type = inputs[i].type;
        input.value = tds[i].innerHTML;
        backup[i] = tds[i].innerHTML;
        tds[i].appendChild(input);
        tds[i].removeChild(tds[i].firstChild);
    }
    tds[6].innerHTML = '<button class="cancel" title="Cancelar"><span class="material-symbols-outlined">close</span></button>'+
                        '<button class="save" title="Salvar"><span class="material-symbols-outlined">check</span></button>';
    tds[6].firstElementChild.addEventListener("click", () => cancelEdit(tds, backup));
    tds[6].lastElementChild.addEventListener("click", () => saveEdit(tds));
}

function cancelEdit(e, backup){
    for(let i = 0; i <= 5; i++){
        e[i].innerHTML = backup[i];
    }
    e[6].innerHTML = '<button class="delete" title="Remover"><span class="material-symbols-outlined">remove</span></button>'+
                    '<button class="edit" title="Editar"><span class="material-symbols-outlined">edit</span></button>';
    e[6].firstElementChild.addEventListener("click", () => delTd(e[6]));
    e[6].lastElementChild.addEventListener("click", () => editTr(e[6]));
}
function saveEdit(e){
    for(let i = 0; i <= 5; i++){
        e[i].innerHTML = e[i].firstElementChild.value;
    }
    e[6].innerHTML = '<button class="delete" title="Remover"><span class="material-symbols-outlined">remove</span></button>'+
                    '<button class="edit" title="Editar"><span class="material-symbols-outlined">edit</span></button>';
    e[6].firstElementChild.addEventListener("click", () => delTd(e[6]));
    e[6].lastElementChild.addEventListener("click", () => editTr(e[6]));
}

function del() {
    const trs = tbody.querySelectorAll("tr");
    for (tr of trs) tbody.removeChild(tr);
}
function delTd(e){
    e.parentNode.parentNode.removeChild(e.parentNode);
}

function isSet() {
    for (i of inputs) if (!i.value) return false;
    return true;
}
document.querySelectorAll('input').forEach(input => {
    input.addEventListener('input', function() {
        if (this.value) {
            this.classList.add('has-value');
        } else {
            this.classList.remove('has-value');
        }
    });
});

function resetInputs(){
    for(i of inputs){
        i.classList.remove('has-value');
    }
}

function openForm(){
    form.style.display = "flex";
    resetInputs();
}

function closeForm(){
    form.style.display = "none";
}