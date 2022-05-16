// async function get() {
//     await fetch('/testuje', {
//         method: "GET"
//     }).then(restReturnedValue => restReturnedValue.json())
//         .then(valueJson => console.log(valueJson))
// }
//
// const button = document.getElementById("nowyButton");
// button.addEventListener("click", get);


function changeQuantity() {
    let input = document.getElementById("quantity");
    console.log(input);
    let hiddenInput = document.getElementById("productID");
// let input = document.getElementsByClassName("quantityOfOrder");

    input.addEventListener('input', function (evt) {
        console.log(this.value);
        console.log(hiddenInput.value);

        fetch("/add_quantity/" + hiddenInput.value + '/' + this.value)
            .then(restReturnedValue => restReturnedValue.json())
            .then(valueJson => {
                let subtotal = document.getElementById("subtotal");
                subtotal.innerHTML = valueJson;
            })
    })
}

// function changeBadgeColor() {
//     let badgeElement = document.getElementById("badge");
//     badgeElement.classList.remove("badge-secondary")
//     badgeElement.classList.add("badge-danger");
//
//     fetch("/shopping_cart_size")
//         .then(value => value.json())
//         .then(valueJson => console.log(valueJson + "weszło mi tutaj"));
//
//
//
// }




let addToCart = document.getElementsByClassName("btn-success");

for (let i = 0; i < addToCart.length; i++) {

    addToCart.item(i).addEventListener('click',  function (evt) {

      fetch("/add_to_cart/" + addToCart.item(i).name)
            .then(product => product.json())
            .then(valueJson => console.log(valueJson));

    })


}


console.log(window.location.href);

window.onload = function () {
    changeQuantity();

}