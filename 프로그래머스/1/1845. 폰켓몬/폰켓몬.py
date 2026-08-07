def solution(nums):
    hash = {}

    for p in nums:
        hash[p] = hash.get(p, 0) + 1

    pick = len(nums) / 2

    if len(hash) >= pick:
        return pick
    else:
        return len(hash)