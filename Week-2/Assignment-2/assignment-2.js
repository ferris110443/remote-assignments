function avg(data) {
    let averagePrice = 0;
    let sumPrice = data.products.reduce((sum , item)=>{
        sum += item.price;
        return sum
    },0)
    averagePrice = sumPrice / data.size;
    return averagePrice;
}
console.log(
    avg({
        size: 3,
        products: [
            {
                name: 'Product 1',
                price: 100,
            },
            {
                name: 'Product 2',
                price: 700,
            },
            {
                name: 'Product 3',
                price: 250,
            },
        ],
    })
); // should print the average price of all products
