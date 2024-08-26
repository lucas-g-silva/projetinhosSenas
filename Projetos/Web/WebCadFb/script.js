const inputs = document.querySelectorAll(".input");
const tbody = document.querySelector("tbody");
const table = document.querySelector("tbody");
const form = document.querySelector("main");
const body = document.body;

refreshData();

$(document).ready(function () {
    var $phoneMask = $("#phone");
    $phoneMask.mask('(00) 00000-0000', { reverse: false });
});


async function add() {
    if (isSet()) {
        let num = 0
        db.ref().child("cadastros").get().then((snapshot) => {
            if (snapshot.exists()) {
                snapshot.forEach(cad => {
                    num++
                });
            }
        }).catch((error) => {
            console.error(error);
        }).then(() => {
            db.ref('cadastros/' + num).set({
                num,
                nome: inputs[0].value,
                email: inputs[1].value,
                telefone: inputs[2].value,
                endereco: inputs[3].value,
                cidade: inputs[4].value,
                estado: inputs[5].value
            }).then(() => {
            }).catch((error) => {
                alert(error);
            });
            closeForm();
            refreshData();
        })

    } else alert("Preencha todos os campos!");
}

function refreshData() {
    tbody.innerHTML = null;
    db.ref().child("cadastros").get().then((snapshot) => {
        if (snapshot.exists()) {
            snapshot.forEach(cad => {
                const tr = table.insertRow(table.rows.length);
                createTd(cad.val().num, tr);
                createTd(cad.val().nome, tr);
                createTd(cad.val().email, tr);
                createTd(cad.val().telefone, tr);
                createTd(cad.val().endereco, tr);
                createTd(cad.val().cidade, tr);
                createTd(cad.val().estado, tr);
                let td = tr.insertCell(tr.cells.length);
                td.innerHTML = '<button class="delete" title="Remover"><span class="material-symbols-outlined">remove</span></button>' +
                    '<button class="edit" title="Editar"><span class="material-symbols-outlined">edit</span></button>';
                td.firstElementChild.addEventListener("click", () => delTr(tr));
                td.lastElementChild.addEventListener("click", () => editTr(tr));
            });
        } else {
            console.log("No data available");
        }
    }).catch((error) => {
        console.error(error);
    });
}

function createTd(value, tr) {
    const td = tr.insertCell(tr.cells.length);
    td.innerHTML = value;
}

function editTr(e) {
    const tr = e;
    const tds = tr.children;
    for (let i = 1; i <= 6; i++) {
        const input = document.createElement("input");
        input.type = inputs[i - 1].type;
        input.value = tds[i].innerHTML;
        tds[i].innerHTML = null;
        tds[i].appendChild(input);
    }
    tds[7].innerHTML = '<button class="cancel" title="Cancelar"><span class="material-symbols-outlined">close</span></button>' +
        '<button class="save" title="Salvar"><span class="material-symbols-outlined">check</span></button>';
    tds[7].firstElementChild.addEventListener("click", () => refreshData());
    tds[7].lastElementChild.addEventListener("click", () => saveEdit(tds));
}

function saveEdit(e) {
    db.ref('cadastros/' + e[0].innerHTML).update({
        nome: e[1].firstElementChild.value,
        email: e[2].firstElementChild.value,
        telefone: e[3].firstElementChild.value,
        endereco: e[4].firstElementChild.value,
        cidade: e[5].firstElementChild.value,
        estado: e[6].firstElementChild.value
    }).catch((error) => {
        alert(error);
    });
    refreshData();
}

function del() {
    db.ref('cadastros').remove().then(refreshData());
}
function delTr(tr) {
    var index = tr.firstElementChild.innerHTML
    var last = table.lastElementChild.firstElementChild.innerHTML;
    for (let i = index + 1; i < last; i++) {
        db.ref().child("cadastros" + i).get().then((snapshot) => {
            if (snapshot.exists()) {
                db.ref('cadastros/' + i-1).update(snapshot).catch((error) => {alert(error);});
            } else {
                console.log("No data available");
            }
        }).catch((error) => {
            console.error(error);
        });
    }
    db.ref('cadastros/' + last).remove().then(refreshData());
}

function isSet() {
    for (i of inputs) if (!i.value) return false;
    return true;
}
document.querySelectorAll('input').forEach(input => {
    input.addEventListener('input', function () {
        if (this.value) {
            this.classList.add('has-value');
        } else {
            this.classList.remove('has-value');
        }
    });
});

function resetInputs() {
    for (i of inputs) {
        i.classList.remove('has-value');
        i.value = null;
    }
}

function openForm() {
    form.style.display = "flex";
    document.querySelector(".blackout").style.display = "block";
    document.querySelector(".blackout").style.opacity = "1";
    resetInputs();
}

function closeForm() {
    form.style.display = "none";
    document.querySelector(".blackout").style.opacity = "0";
    setTimeout(() => {
        document.querySelector(".blackout").style.display = "none";
    }, 500);
}

function toggleTheme() {
    const icon = document.querySelector(".theme").firstElementChild;
    body.classList.toggle('dark');
    icon.innerHTML = body.classList.contains("dark") ? "dark_mode" : "light_mode";
}