function solution(k, m, score) {
    let result = 0;
    let i = m - 1;
    score.sort((a,b) => b - a);
    
    
    while(i < score.length) {
        result += (score[i] * m);
        i += m;
    }
    
    return result;
}