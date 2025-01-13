function solution(my_string, n) {
    let result = '';
    
    for (let i = 0; i < my_string.length; i++) {
        let c = my_string[i];
        for(let j = 0; j < n; j++) {
            result += c;
        }
    }
    
    return result;
}