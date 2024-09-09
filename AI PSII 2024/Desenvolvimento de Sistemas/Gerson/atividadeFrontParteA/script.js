function send() {
    const inputText = document.getElementById("inputText").value;
    const textArea = document.getElementById("textArea").value;
    const checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
    var checkValues = [];
    checkboxes.forEach(checkbox => {
        checkValues.push(checkbox.value);
    });

    const radioButton = document.querySelector('input[type="radio"]:checked');
    var radioValue = radioButton ? radioButton.value : "Nenhum";

    const outputs = document.querySelectorAll(".shInput");

    if (inputText.trim() !== "" && textArea.trim() !== "") {
        outputs[0].innerHTML = "Caixa de Texto: " + inputText;
        outputs[1].innerHTML = "Textarea: " + textArea;
        outputs[2].innerHTML = "Checkboxes selecionadas: " + (checkValues.length > 0 ? checkValues.join(", ") : "Nenhum");
        outputs[3].innerHTML = "Radio selecionado: " + radioValue;
    } else {
        alert("Preencha todos os campos!");
    }
}

function addRow() {
    const inputName = document.getElementById("inputName").value;
    const inputAge = document.getElementById("inputAge").value;
    const inputEmail = document.getElementById("inputEmail").value;

    const table = document.getElementById("table");

    if(inputName !== "" && inputAge !== "" && inputEmail !== ""){
        var row = table.insertRow();
        const cell1 = row.insertCell(0);
        cell1.innerHTML = inputName;
        const cell2 = row.insertCell(1);
        cell2.innerHTML = inputAge;
        const cell3 = row.insertCell(2);
        cell3.innerHTML = inputEmail;
    } else{
        alert("Preencha todos os campos!");
    }
}