function binarySearchPosition(numbers, target) {
// your code here
    let firstNumIndex = 0;
    let lastNumIndex = numbers.length-1;


    while (lastNumIndex>=firstNumIndex){
        let midNumIndex = Math.floor((firstNumIndex+lastNumIndex)/2);
        // console.log("mid num :" +midNumIndex)
        if (target === numbers[midNumIndex]){
            return midNumIndex;
        } else if (numbers[midNumIndex] > target){
            lastNumIndex = midNumIndex -1 ;
        } else {
            firstNumIndex = midNumIndex+1;
        }
    }
    return -1;

}


console.log(binarySearchPosition([1, 2, 5, 6, 7], 1)); // should print 0
console.log(binarySearchPosition([1, 2, 5, 6, 7], 6)); // should print 3