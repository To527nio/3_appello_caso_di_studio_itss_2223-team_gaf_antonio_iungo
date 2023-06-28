
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.*;

import org.example.Homework2;
import static org.junit.jupiter.api.Assertions.*;

public class TestHomework2 {
    //T1
    @Test
    @DisplayName("arrIsNullorEmpty")
    void arrIsNull()
    {
        assertNull(Homework2.mergeSort(null, new int[]{1}, new int[]{2,3}));
    }
    //T2
    @Test
    @DisplayName("l is null")
    void lIsNull()
    {
        assertNull(Homework2.mergeSort(new int[]{3,5,7}, null, new int[]{5,7}));
    }

    //T3
    @Test
    @DisplayName("r is null")
    void rIsNull()
    {
        assertNull(Homework2.mergeSort(new int[]{3,5,7},new int[]{5,7},null));
    }

    //T4
    @Test
    @DisplayName("lisEmpty")
    void lIsEmpty()
    {
        assertArrayEquals(new int[]{3,5,7},Homework2.mergeSort(new int[]{3,5,7}, new int[]{}, new int[]{5,7}));
    }
    //T5
    @Test
    @DisplayName("lisEmpty")
    void rIsEmpty()
    {
        assertArrayEquals(new int[]{3,5,7},Homework2.mergeSort(new int[]{3,5,7},new int[]{},new int[]{5,7}));
    }

    //T6
    @Test
    @DisplayName("ArrisEmpty")
    void ArrIsEmpty()
    {
        assertArrayEquals(new int[]{},Homework2.mergeSort(new int[]{}, new int[]{1}, new int[]{2, 3}));
    }

    //T7
    @Test
    @MethodSource("Test7")
    void LGreaterThanR()
    {
        assertArrayEquals(new int[]{3,5,7},Homework2.mergeSort(new int[]{3,5,7},new int[]{3},new int[]{}));
    }


    //T8
    @Test
    @DisplayName("ArrayOrderAsc")
    void arrOrdAsc()
    {
        assertArrayEquals(new int[]{3,5,7},Homework2.mergeSort(new int[]{3,5,7},new int[]{3},new int[]{5,7}));
    }

    //T9
    @Test
    @DisplayName("ArrayDim1LEmptyREmpty")
    void ArrayDim1LEmptyREmpty()
    {
        assertArrayEquals(new int[]{3},Homework2.mergeSort(new int[]{3},new int[]{},new int[]{}));
    }

    //T10
    @Test
    @DisplayName("ArrayDim1RDimArrLEmpty")
    void ArrayDim1RDimArrLEmpty()
    {
        assertArrayEquals(new int[]{3},Homework2.mergeSort(new int[]{3},new int[]{},new int[]{3}));
    }

    //T11
    @Test
    @DisplayName("ArrayDim1RNotEmptyLNotEmpty")
    void ArrayDim1RNotEmptyLNotEmpty()
    {
        assertArrayEquals(new int[]{3},Homework2.mergeSort(new int[]{3},new int[]{4},new int[]{3}));
    }

    //T12
    @Test
    @DisplayName("ArrayEvenLEqualsR")
    void ArrayEvenLEqualsR()
    {
        assertArrayEquals(new int[]{2,3},Homework2.mergeSort(new int[]{3,2},new int[]{3},new int[]{2}));
    }

    //T13
    @Test
    @DisplayName("ArrayEvenLEmpty")
    void ArrayEvenLEmpty()
    {
        assertArrayEquals(new int[]{3,5,7,2},Homework2.mergeSort(new int[]{3,5,7,2}, new int[]{}, new int[]{4,7,2}));
    }

    //T14
    @Test
    @DisplayName("ArrayOddLMinorThenL")
    void ArrayOddLMinorThenL()
    {
        assertArrayEquals(new int[]{3,5,7},Homework2.mergeSort(new int[]{3,5,7}, new int[]{3}, new int[]{5,7}));
    }


        // T15
        @Test
        @DisplayName("ArraySortedInDescendingOrder")
        @MethodSource("ArraySortedInDescendingOrderArguments")
        void ArraySortedInDescendingOrder() {
            assertArrayEquals(new int[] {1,3,5,7,9}, Homework2.mergeSort(new int[]{9, 7, 5, 3, 1}, new int[]{9, 7}, new int[]{5, 3, 1}));
        }

        //T16
        @Test
        @DisplayName("LandRalreadyOrderedButArrIsNotOrdered")
        void LandRalreadyOrderedButArrIsNotOrdered()
        {
            assertArrayEquals(new int[]{5,6,8,9},Homework2.mergeSort(new int[]{8,9,5,6}, new int[]{8,9}, new int[]{5,6}));
        }

}







