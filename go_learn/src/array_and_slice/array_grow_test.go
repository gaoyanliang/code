package array_and_slice

import (
	"fmt"
	"testing"
)

func TestArrayGrow(t *testing.T) {
	s := make([]int, 0)
	fmt.Printf("s len = %d, s cap = %d", len(s), cap(s))
	fmt.Println("=============")

	oldCap := cap(s)

	for i := 0; i < 2048; i++ {
		s = append(s, i)

		newCap := cap(s)

		if newCap != oldCap {
			fmt.Printf("[%d -> %4d] cap = %-4d  |  after append %-4d  cap = %-4d\n", 0, i-1, oldCap, i, newCap)
			oldCap = newCap
		}
	}
}

func TestCaseFour(t *testing.T) {
	m := map[string]string{}
	m["s"] = "s"
	s := []int{1, 2}
	s = append(s, 4, 5, 6)
	fmt.Printf("len=%d, cap=%d", len(s), cap(s))
}
