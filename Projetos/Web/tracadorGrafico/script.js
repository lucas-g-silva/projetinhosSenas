const canvas = document.getElementById("graphic");
const ctx = canvas.getContext("2d");
const dpr = window.devicePixelRatio || 1;
canvas.width = canvas.clientWidth * dpr;
canvas.height = canvas.clientHeight * dpr;
ctx.scale(dpr, dpr);

var scale = 20;
var click = false;
var org = {
    x: canvas.clientWidth / 2,
    y: canvas.clientHeight / 2
}
draw();

function draw() {

    const width = canvas.clientWidth;
    const height = canvas.clientHeight;

    ctx.clearRect(0, 0, width, height);

    graphic(ctx, width, height);
    parabol(ctx, width, height);
    calc();
};

function graphic(ctx, width, height) {
    ctx.lineWidth = 1;
    ctx.font = "10px Inter";
    ctx.fillStyle = "rgb(100, 100, 100)";

    for (let i = org.x + scale; i <= width; i += scale) {
        ctx.strokeStyle = (i - org.x) % (5 * scale) == 0 ? "rgb(35, 35, 35)" : "rgb(30, 30, 30)";
        ctx.beginPath();
        ctx.moveTo(i, 0);
        ctx.lineTo(i, height);
        ctx.stroke();

        if ((i - org.x) % (5 * scale) == 0) {
            ctx.fillText((i - org.x) / scale, i - ctx.measureText((i - org.x) / scale).width / 2, org.y + 15);
        }
    }
    for (let i = org.x - scale; i >= 0; i -= scale) {
        ctx.strokeStyle = (i - org.x) % (5 * scale) == 0 ? "rgb(35, 35, 35)" : "rgb(30, 30, 30)";
        ctx.beginPath();
        ctx.moveTo(i, 0);
        ctx.lineTo(i, height);
        ctx.stroke();

        if ((i - org.x) % (5 * scale) == 0) {
            ctx.fillText((i - org.x) / scale, i - ctx.measureText((i - org.x) / scale).width / 2, org.y + 15);
        }
    }
    for (let i = org.y + scale; i <= height; i += scale) {
        ctx.strokeStyle = (i - org.y) % (5 * scale) == 0 ? "rgb(35, 35, 35)" : "rgb(30, 30, 30)";
        ctx.beginPath();
        ctx.moveTo(0, i);
        ctx.lineTo(width, i);
        ctx.stroke();
        if ((i - org.y) % (5 * scale) == 0) {
            ctx.fillText((i - org.y) / -scale, org.x - ctx.measureText((i - org.y) / -scale).width - 5, i + 5);
        }
    }
    for (let i = org.y - scale; i >= 0; i -= scale) {
        ctx.strokeStyle = (i - org.y) % (5 * scale) == 0 ? "rgb(35, 35, 35)" : "rgb(30, 30, 30)";
        ctx.beginPath();
        ctx.moveTo(0, i);
        ctx.lineTo(width, i);
        ctx.stroke();

        if ((i - org.y) % (5 * scale) == 0) {
            ctx.fillText((i - org.y) / -scale, org.x - ctx.measureText((i - org.y) / -scale).width - 5, i + 5);
        }
    }
    ctx.fillText("0", org.x - ctx.measureText("0").width - 5, org.y + 15)
    ctx.lineWidth = 2;
    ctx.strokeStyle = "rgb(40, 40, 40)";
    ctx.beginPath();
    ctx.moveTo(org.x, 0);
    ctx.lineTo(org.x, height);
    ctx.stroke();
    ctx.beginPath();
    ctx.moveTo(0, org.y);
    ctx.lineTo(width, org.y);
    ctx.stroke();
}

function parabol(ctx, width, height) {
    var a = document.getElementById("a").value;
    var b = document.getElementById("b").value;
    var c = document.getElementById("c").value;

    ctx.strokeStyle = "white";
    if (a != "" && b != "" && c != "") {
        a = Number(document.getElementById("a").value);
        b = Number(document.getElementById("b").value);
        c = Number(document.getElementById("c").value);
        ctx.beginPath();
        for (let x = -org.x; x <= org.x; x += 0.01) {
            var y = (a * x * x) + (b * x) + (c);

            const canvasX = org.x + x * scale;
            const canvasY = org.y - y * scale;

            if (x === -org.x) {
                ctx.moveTo(canvasX, canvasY);
            } else {
                ctx.lineTo(canvasX, canvasY);
            }
        }
        ctx.stroke();
    }
}

function calc() {
    var a = document.getElementById("a").value;
    var b = document.getElementById("b").value;
    var c = document.getElementById("c").value;

    const calcArea = document.getElementById("calcRaizes");
    while (calcArea.firstChild) {
        calcArea.removeChild(calcArea.firstChild);
    }
    if (a != "" && b != "" && c != "") {
        a = Number(document.getElementById("a").value);
        b = Number(document.getElementById("b").value);
        c = Number(document.getElementById("c").value);

        const xBox = document.createElement("div");
        xBox.classList.add("x-box");
        createCalcStep(xBox, "x", "-b ∓ √(b² - 4ac)", "2a");
        createCalcStep(xBox, "x", "-(" + b + ") ∓ √((" + b + ")² - 4*(" + a + ")*(" + c + "))", "2*(" + a + ")");
        createCalcStep(xBox, "x", -b + " ∓ √(" + (b * b) + " - " + (4 * a * c) + ")", (2 * a));
        createCalcStep(xBox, "x", -b + " ∓ √(" + (b * b - 4 * a * c) + ")", (2 * a));
        createCalcStep(xBox, "x", -b + " ∓ " + (Math.sqrt(b * b - 4 * a * c).toFixed(2)), (2 * a));
        calcArea.appendChild(xBox);

        const raizes = document.createElement("div");
        raizes.classList.add("raizes-box");

        const x1Box = document.createElement("div");
        x1Box.classList.add("x-box");

        createCalcStep(x1Box, "x1", -b + " - " + (Math.sqrt(b * b - 4 * a * c).toFixed(2)), (2 * a));
        createCalcStep(x1Box, "x1", (-b - (Math.sqrt(b * b - 4 * a * c).toFixed(2))).toFixed(2), (2 * a));
        createCalcStep(x1Box, "x1", ((-b - (Math.sqrt(b * b - 4 * a * c).toFixed(2))) / (2 * a)).toFixed(2));
        raizes.appendChild(x1Box);
        
        const x2Box = document.createElement("div");
        x2Box.classList.add("x-box");

        createCalcStep(x2Box, "x2", (-b + " + " + Math.sqrt(b * b - 4 * a * c).toFixed(2)), (2 * a));
        createCalcStep(x2Box, "x2", (Math.sqrt(b * b - 4 * a * c).toFixed(2) - b).toFixed(2), (2 * a));
        createCalcStep(x2Box, "x2", ((Math.sqrt(b * b - 4 * a * c).toFixed(2) - b).toFixed(2) / (2 * a)).toFixed(2));
        raizes.appendChild(x2Box);

        calcArea.appendChild(raizes);
    }

    function createCalcStep(parent, strx, str1, str2) {
        const step = document.createElement("div");
        step.classList.add("bask");

        const x = document.createElement("label");
        x.innerHTML = strx;
        step.appendChild(x);

        const equals = document.createElement("label");
        equals.innerHTML = "="
        step.appendChild(equals);

        if (str2 !== undefined) {
            const fraction = document.createElement("div");
            fraction.classList.add("fraction");

            const top = document.createElement("label");
            top.innerHTML = str1;
            fraction.appendChild(top);

            const bottom = document.createElement("label");
            bottom.innerHTML = str2;
            fraction.appendChild(bottom);

            step.appendChild(fraction);
        } else {
            const str = document.createElement("label");
            str.innerHTML = str1;
            step.appendChild(str);
        }
        parent.appendChild(step);
    }
}

var diference = null;

function getPosicaoMouse(event) {
    const rect = canvas.getBoundingClientRect();
    const x = event.clientX - rect.left;
    const y = event.clientY - rect.top;
    return { x, y };
}

canvas.addEventListener("mousemove", (event) => {
    if (click) {
        var pMouse = getPosicaoMouse(event);

        org.x = pMouse.x - diference.x
        org.y = pMouse.y - diference.y
        draw();
    }
});

canvas.addEventListener("mousedown", (evt) => {
    click = true;
    diference = { x: getPosicaoMouse(evt).x - org.x, y: getPosicaoMouse(evt).y - org.y };
});
canvas.addEventListener("mouseup", () => {
    click = false;
});
canvas.addEventListener("mouseout", () => {
    click = false;
});

function zoomIn() {
    if (scale < 30) scale += 2;
    draw();
}

function zoomOut() {
    if (scale > 10) scale -= 2;
    draw();
}

function toggleAccordion(id){
    document.getElementById(id).classList.toggle("active");
}