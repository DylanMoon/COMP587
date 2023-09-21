// 0! = 1
// n! = n * (n - 1)!
function method factorial(n: int): int
	requires n >= 0;
	ensures factorial(0) == 1;
	ensures n > 0 ==> factorial(n) == n * factorial(n - 1);
{
	if n == 0 then
		1
	else 
		n * factorial(n - 1)
}

method factorial_iterative(n: int) returns (result: int)
	requires n >= 0;
	ensures result == factorial(n);
{
	result := 1;
	var index := 1;
	while (index <= n)
	invariant 1 <= index <= n + 1;
	invariant result == factorial(index - 1);
	{
		result := result * index;
		index := index + 1;
	}
}
