type Colored = {
    color : string;
}
type Rectangle = {
    width: number;
    height: number;
};
type Circle = {
    radius: number;
};

type ColoredRectangle = Colored & Rectangle;
type ColoredCircle = Colored & Circle;