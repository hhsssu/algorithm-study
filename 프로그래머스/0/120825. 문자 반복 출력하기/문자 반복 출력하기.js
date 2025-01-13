function solution(my_string, n) {
    let array = my_string.split('');
    let result = [];
    
    for (let i = 0; i < my_string.length; i++) {
        for(let j = 0; j < n; j++) {
            result.push(array[i])
        }
    }
    
    return result.join('');
}