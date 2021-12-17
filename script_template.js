window.addEventListener('scroll',function(){
    var header_list = document.querySelector(".header-list");
    header_list.classList.toggle('sticky',window.scrollY > 0);
    var header = document.querySelector("header");
    header.classList.toggle('sticky1',window.scrollY > 0);
})