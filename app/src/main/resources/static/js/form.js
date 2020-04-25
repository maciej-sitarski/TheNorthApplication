let firstPositiveThumb = document.querySelector('#firstPositiveThumb');
let firstNegativeThumb = document.querySelector('#firstNegativeThumb');

firstPositiveThumb.addEventListener('click', () => {
    if(firstNegativeThumb.style.backgroundColor='white'){
        firstPositiveThumb.style.backgroundColor='green'
    } else {

    }
    firstPositiveThumb.style.backgroundColor='green'



})
firstNegativeThumb.addEventListener('click', () => firstNegativeThumb.style.backgroundColor='red')



