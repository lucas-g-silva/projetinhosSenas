const canvas = document.getElementById("gameboard");
const ctx = canvas.getContext("2d");

function render() {
    const width = canvas.clientWidth;
    const height = canvas.clientHeight;
    ctx.clearRect(0, 0, width, height);
    scenario();
    requestAnimationFrame(render);
}
i = 0;
function scenario() {
    var bg = new Image();
    bg.onload = function () {
        ctx.drawImage(bg, i, 0);
        i++;
    };
    bg.src = "assets/background.png";
}

render();