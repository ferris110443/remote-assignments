function count(input) {
    const countObj = {}
    input.forEach( (element) => {
        if (countObj[element] === undefined){
            countObj[element] = 1;
        } else {
            countObj[element] = countObj[element]+1;
        }
    })
    return countObj;
}
let input1 = ["a", "b", "c", "a", "c", "a", "x"];
console.log(count(input1));
// should print {a:3, b:1, c:2, x:1}
function groupByKey(input) {
    const countObj = {}
    input.forEach((element)=>{
        if(countObj[element.key] === undefined){
            countObj[element.key] = element.value;
        } else {
            countObj[element.key] = countObj[element.key] +  element.value;
        }
    })
    return countObj;

}
let input2 = [
    { key: "a", value: 3 },
    { key: "b", value: 1 },
    { key: "c", value: 2 },
    { key: "a", value: 3 },
    { key: "c", value: 5 },
];
console.log(groupByKey(input2));
// should print {a:6, b:1, c:7}