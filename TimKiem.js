const search = () =>{
    const search_box =document.getElementById("search").value.toLowerCase();
    document.getElementById("product-list");
    const product = document.querySelectorAll(".container-box");
    const name = document.getElementsByTagName("a");

    for (let i = 0; i<name.length; i++){
        let match= product[i].getElementsByTagName('a')[0];

        if(match){
        let textvalue =   match.textContent || match.innerHTML
            if(textvalue.toLowerCase().indexOf(search_box)>-1){
                product[i].style.display = "";
            }else {
                product[i].style.display = "none";
            }

        }
    }



}




