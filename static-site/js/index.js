// Pixel effect on click
document.addEventListener('click', createPixelEffect);

function createPixelEffect(event) {
    const colors = ['#96CEB4', '#FFEEAD', '#A02334', '#FFAD60'];
    
    for (let i = 0; i < 20; i++) {
        const pixel = document.createElement('div');
        pixel.className = 'pixel';
        
        const x = event.clientX + (Math.random() - 0.5) * 50;
        const y = event.clientY + (Math.random() - 0.5) * 50;
        
        pixel.style.backgroundColor = colors[Math.floor(Math.random() * colors.length)];
        pixel.style.left = `${x}px`;
        pixel.style.top = `${y}px`;
        
        document.body.appendChild(pixel);
        
        const angle = Math.random() * Math.PI * 2;
        const velocity = Math.random() * 5 + 2;
        const dx = Math.cos(angle) * velocity;
        const dy = Math.sin(angle) * velocity;
        
        let posX = x;
        let posY = y;
        let opacity = 1;
        
        const animate = () => {
            if (opacity <= 0) {
                pixel.remove();
                return;
            }
            
            posX += dx;
            posY += dy;
            opacity -= 0.02;
            
            pixel.style.left = `${posX}px`;
            pixel.style.top = `${posY}px`;
            pixel.style.opacity = opacity;
            
            requestAnimationFrame(animate);
        };
        
        requestAnimationFrame(animate);
    }
}

// Glitch effect on button
const button = document.querySelector('.retro-button');
button.addEventListener('click', () => {
    button.style.animation = 'none';
    button.offsetHeight; // Trigger reflow
    button.style.animation = 'glitch 0.3s ease';
});

// Random glitch effect on title
setInterval(() => {
    const title = document.querySelector('.glitch');
    if (Math.random() > 0.95) {
        title.style.transform = `translate(${Math.random() * 4 - 2}px, ${Math.random() * 4 - 2}px)`;
        setTimeout(() => {
            title.style.transform = 'translate(0, 0)';
        }, 100);
    }
}, 100);

// Add scanline effect
const scanline = document.getElementById('scanline');
let scanlinePosition = 0;
setInterval(() => {
    scanlinePosition = (scanlinePosition + 1) % 100;
    scanline.style.transform = `translateY(${scanlinePosition}vh)`;
}, 16);