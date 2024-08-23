const inputs = document.querySelectorAll(".input");
const tbody = document.querySelector("tbody");



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
        td.innerHTML = '<button class="delete"><span class="material-symbols-outlined">remove</span></button>';
        td.firstElementChild.addEventListener("click", () => delTd(td));
        tr.appendChild(td);
    } else alert("Preencha todos os campos!");
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