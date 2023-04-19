def solution(sizes):
    max_w=0
    max_h=0
    for width, height in sizes:
        if width < height:
            width, height = height, width
        max_w = max(max_w, width)
        max_h = max(max_h, height)
    return max_w * max_h
