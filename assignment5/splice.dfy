method splice_in(a: array<int>, index: int, add_these: array<int>) returns (result: array<int>)
	requires 0 <= index < a.Length;
	ensures fresh(result);
	ensures result.Length == a.Length + add_these.Length;
	ensures forall i :: 0 <= i < index ==> a[i] == result[i];
	ensures forall i :: 0 <= i < add_these.Length ==> add_these[i] == result[i + index];
	ensures forall i :: index <= i < a.Length ==> a[i] == result[i + add_these.Length];
{
	result := new int[a.Length + add_these.Length];

	// copy first part in
	var pos := 0;
	while (pos < index)
	invariant 0 <= pos <= index;
	invariant result[0..pos]==a[0..pos];
	{
		result[pos] := a[pos];
		pos := pos + 1;
	}

	// copy in the addition
	pos := 0;
	while (pos < add_these.Length)
	invariant 0 <= pos <= add_these.Length;
	invariant result[0 .. index] == a[0 .. index];
	invariant result[index .. index + pos] == add_these[0..pos];
	{
		result[index + pos] := add_these[pos];
		pos := pos + 1;
	}

	// copy the last part in
	pos := index;
	while (pos < a.Length)
	invariant 0 <= pos <= a.Length;
	invariant result[0 .. index] == a[0 .. index];
	invariant result[index..index+ add_these.Length] == add_these[0.. add_these.Length];
	invariant result[index + add_these.Length .. add_these.Length + pos] == a[index .. pos];
	{
		result[pos + add_these.Length] := a[pos];
		pos := pos + 1;
	}
}
