var xPipes, yBird

const birdImg = [
    "assets/f_high.png",
    "assets/f_mid.png",
    "assets/f_low.png"
];

var i = 0;
setInterval(() => {
    const bird = document.querySelector(".bird");
    bird.src = birdImg[i];
    i = i < birdImg.length - 1 ? i + 1 : 0;
}, 150);

let gravity = 0.25;
let altura = 2.5;

setInterval(() => {
    const bird = document.querySelector(".bird");
    updateBirdY(bird.style.top - altura)
}, 150);

setInterval(() => {
    altura -= gravity;
}, 500);

document.addEventListener('keydown', (event) => {
    if (event.code === 'Space') {
        altura = 2.5;
    }
});


function updateBirdY(newY){
    document.querySelector(".bird").style.top = newY;
}