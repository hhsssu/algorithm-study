function solution(arr) {
    let result = 0;
    arr.map((x) => {
        result += x;
    })
    
    return result / arr.length;
}