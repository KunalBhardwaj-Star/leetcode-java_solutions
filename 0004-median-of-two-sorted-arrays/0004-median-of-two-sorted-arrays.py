class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        len1 = len(nums1)
        len2 = len(nums2)
        size = len1 + len2

        merged = [0] * (size)

        p1 = 0
        p2 = 0
        p3 = 0


        while p1 < len1 and p2 < len2 :
            if nums1[p1] > nums2[p2] :
                merged[p3] = nums2[p2]
                p2 += 1
                p3 += 1

            else :
                merged[p3] = nums1[p1]
                p1 += 1
                p3 += 1

        while p1 < len1 :
            merged[p3] = nums1[p1]
            p1 += 1
            p3 += 1

        while p2 < len2 :
            merged[p3] = nums2[p2]
            p2 += 1
            p3 += 1

        return merged[size // 2] if size % 2 != 0 else (merged[size // 2] + merged[size // 2 - 1]) / 2
