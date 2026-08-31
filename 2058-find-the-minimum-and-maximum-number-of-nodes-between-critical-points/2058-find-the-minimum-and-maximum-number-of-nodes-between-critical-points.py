# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        temp = head.next
        prev = head

        node = []

        idx = 1

        while temp.next:
            curr = temp.val
            pre = prev.val
            upcoming = temp.next.val

            if (pre < curr and curr > upcoming) or (pre > curr and curr < upcoming) :
                node.append(idx)
            
            idx += 1
            prev = temp
            temp = temp.next

        if len(node) < 2 :
            return [-1 , -1]

        mx = node[len(node) - 1] - node[0]

        mn = math.inf

        for i in range(1 , len(node)):
            mn = min(mn , node[i] - node[i-1])

        return [mn , mx]
        