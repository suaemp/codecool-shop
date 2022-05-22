function changeQuantity() {
    let productQuantityInCart = document.getElementsByClassName("quantityOfOrder");

    for (let i = 0; i < productQuantityInCart.length; i++) {
        productQuantityInCart[i].addEventListener('click', function (evt) {

            fetch("/add_quantity/" + productQuantityInCart[i].name + '/' + this.value)
                .then(restReturnedValue => restReturnedValue.json())
                .then(valueJson => {
                    let subtotal = document.getElementById("subtotal");
                    let total = document.getElementById("total");
                    subtotal.innerHTML = valueJson + ' USD';
                    total.innerHTML = valueJson + ' USD';
                })
        })
    }
}

function deleteItem() {
    let deleteButtons = document.getElementsByClassName("close");

    for (let i = 0; i < deleteButtons.length; i++) {
        deleteButtons[i].addEventListener('click', function (evt)
        {
            fetch("/delete/" + deleteButtons[i].name);
            let buttonToDelete = document.getElementById(deleteButtons[i].name);
            buttonToDelete.style.display = "none";




        })
    }

}

window.onload = function () {
    changeQuantity();
    deleteItem();
}